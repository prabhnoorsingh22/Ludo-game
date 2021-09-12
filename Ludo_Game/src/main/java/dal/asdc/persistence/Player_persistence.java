package dal.asdc.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;
import dal.asdc.persistence.interfaces.IJdbc_connection;
import dal.asdc.persistence.interfaces.IPlayer_persistence;

/**
 * @author Reshma Unnikrishnan **/

public class Player_persistence implements IPlayer_persistence {

	@Override
	public void save_record(IPlayer player) {
		IJdbc_connection jdbc = new Jdbc_connection();
		String create_query = "INSERT into Player (player_id, player_name, player_email, player_password, acc_created_date) "
				+ "values(?,?,?,?,?)";
		try {
			Connection conn = jdbc.createDBConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(create_query);
			preparedStatement.setInt(1, player.getPlayer_id());
            preparedStatement.setString(2, player.getPlayer_name());
            preparedStatement.setString(3, player.getPlayer_email());
            preparedStatement.setString(4, player.getPlayer_password());
            preparedStatement.setString(5, player.getAcc_created_date());
            preparedStatement.executeUpdate();
            conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<IPlayer> select_all_record() {
	        List<IPlayer> player_list = new ArrayList<>();
	        IJdbc_connection jdbc = new Jdbc_connection();
	        String select_all_query = "SELECT * from Players";
	        try {
				Connection conn = jdbc.createDBConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(select_all_query);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    IPlayer player = new Player();
	                    player.setPlayer_id(resultSet.getInt("player_id"));
	                    player.setPlayer_name(resultSet.getString("player_name"));
	                    player.setPlayer_email(resultSet.getString("player_email"));
	                    player.setPlayer_password(resultSet.getString("player_password"));
	                    player.setAcc_created_date(resultSet.getString("acc_created_date"));
	                    player_list.add(player);
	                }
	                conn.close();
	                return player_list;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public void update_record(int player_id, IPlayer player) {
		IJdbc_connection jdbc = new Jdbc_connection();
		 String player_update_query = "UPDATE Player SET player_name = ?, player_email = ?, player_password = ?," +
                 " acc_created_date = ? WHERE player_id = ?";
		 try {
			 Connection conn = jdbc.createDBConnection();
			 PreparedStatement preparedStatement = conn.prepareStatement(player_update_query);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                	 preparedStatement.setInt(1, player.getPlayer_id());
	                     preparedStatement.setString(2, player.getPlayer_name());
	                     preparedStatement.setString(3, player.getPlayer_email());
	                     preparedStatement.setString(4, player.getPlayer_password());
	                     preparedStatement.setString(5, player.getAcc_created_date());
		             preparedStatement.executeUpdate();
	                }
	                conn.close();}
				} catch (SQLException sqlException) {
			        throw new RuntimeException(sqlException);
			    }
			
	}

	@Override
	public IPlayer filter_by_id(int player_id) {
		IJdbc_connection jdbc = new Jdbc_connection();
		String filter_by_id_query = "SELECT * from Player where player_id = ?";
		 try{
			 Connection conn = jdbc.createDBConnection();
	         PreparedStatement preparedStatement = conn.prepareStatement(filter_by_id_query);
	         preparedStatement.setInt(1, player_id);
	         System.out.println("Filter by id query : "+preparedStatement);
	         try (ResultSet resultSet = preparedStatement.executeQuery()) {
	        	 Player player = null;
	             	if (resultSet.next()) {
	             		player = new Player();
	             		player.setPlayer_id(resultSet.getInt("player_id"));
	             		player.setPlayer_name(resultSet.getString("player_name"));
	             		player.setPlayer_email(resultSet.getString("player_email"));
	             		player.setPlayer_password(resultSet.getString("player_password"));
	             		player.setAcc_created_date(resultSet.getString("acc_created_date"));
	                }conn.close();
	                return player;
	            }
	        } catch (SQLException sqlException) {
	            throw new RuntimeException(sqlException);
	        }
	}
	
	@Override
	public IPlayer filter_by_emailid(String player_email) {
		IJdbc_connection jdbc = new Jdbc_connection();
		String filter_by_emailid_query = "SELECT * from Player where player_email = ?";
		 try{
			 Connection conn = jdbc.createDBConnection();
	         PreparedStatement preparedStatement = conn.prepareStatement(filter_by_emailid_query);
	         preparedStatement.setString(1, player_email);
	         try (ResultSet resultSet = preparedStatement.executeQuery()) {
	        	 Player player = null;
	             	if (resultSet.next()) {
	             		player = new Player();
	             		player.setPlayer_name(resultSet.getString("player_name"));
	             		player.setPlayer_email(resultSet.getString("player_email"));
	             		player.setPlayer_password(resultSet.getString("player_password"));
	             		player.setAcc_created_date(resultSet.getString("acc_created_date"));
	                }conn.close();
	                return player;
	            }
	        } catch (SQLException sqlException) {
	            throw new RuntimeException(sqlException);
	        }
	}
	
	//This method is used to get n number of rows from player table
	@Override
	public List<Integer> select_n_players(int n) {
		IJdbc_connection jdbc = new Jdbc_connection();
		List<Integer> player_list = new ArrayList<>();
		String player_list_query = "SELECT * FROM Player LIMIT ?";		
		 try{
			 Connection conn = jdbc.createDBConnection();
	         PreparedStatement preparedStatement = conn.prepareStatement(player_list_query);
	         preparedStatement.setInt(1, n);
	         try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    player_list.add(resultSet.getInt("player_id"));
	                }conn.close();
	                return player_list;
	            }
	        } catch (SQLException sqlException) {
	            throw new RuntimeException(sqlException);
	        }
	}




}
