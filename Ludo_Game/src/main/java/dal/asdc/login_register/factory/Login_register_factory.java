package dal.asdc.login_register.factory;

import dal.asdc.login_register.Login;
import dal.asdc.login_register.Register;
import dal.asdc.login_register.interfaces.ILogin;
import dal.asdc.login_register.interfaces.IRegister;

/**
 * @author Heli Bhavsar**/

public class Login_register_factory {
	public ILogin create_login() {
		return new Login();
	}
	public IRegister create_register() {
		return new Register();
	}
}
