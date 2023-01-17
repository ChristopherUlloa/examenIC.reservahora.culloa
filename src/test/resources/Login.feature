Feature: Login cliente

Scenario: Ingresar datos correctos
	Given un cliente con usuario "admin" y pass "admin"
	When realiza el login
	Then Se autentica OK
	
Scenario: Ingresar datos incorrectos
	Given un cliente con usuario "admin" y pass "teapod"
	When realiza el login
	Then Se obtiene un error "Usuario o contraseña invalidos"

