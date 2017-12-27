package scripts.tradeaccepter;

public enum Argument {

	CUSTOM_COORDINATE("pos"),
	BANK_ALL("bankall"),
	WORLD("world"),
	TRADE_TIMEOUT("maxtrade")
	;
	
	Argument(String command) {
		this.setCommand(command);
	}
	
	private String command;
	
	public String getCommand() {
		return command;
	}

	private void setCommand(String command) {
		this.command = command;
	}
	
	@Override
	public String toString() {
		return command.replaceAll("_", " ").toLowerCase();
	}
	

	
	
	
}
