package scripts.tradeaccepter;

import java.util.HashMap;

import org.tribot.api.General;
import org.tribot.api2007.types.RSTile;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Arguments;

import scripts.util.Misc;

@ScriptManifest(authors = { "Crimson", "The Boys" }, 
	category = "Tools",
	name = "Trade Accepter",
	version = 1.00, 
	description = "Accepts trades.", 
	gameMode = 1)

public class TradeAccepter extends Script implements Arguments {
	
	//Constants
	public static final String TRIAL_ARG = "pos:3533:2222:0 bankall:true world:316 maxtrade:15";
	
	//Variables
	private RSTile idlePos;
	private boolean bankAll = true;
	private int world = -1, tradeKillswitch = 30;
	
	@Override
	public void run() {
		try {
		General.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void passArguments(HashMap<String, String> arg0) {
		String scriptSelect = arg0.get("custom_input");		
		String clientStarter = arg0.get("autostart");		
		String raw = clientStarter != null ? clientStarter : scriptSelect;		
		//input = TRIAL_ARG;
		raw = raw.toLowerCase();
		Misc.ps("Raw input: "+raw);
		String[] split = raw.split(" ");
		
		for (String input : split) {
			for (Argument arg : Argument.values()) {
				if (input.contains(arg.getCommand())) {
					parseArgs(input, arg);
				}
			}
		}
				
	}
	
	private void parseArgs(String input, Argument arg) {
		Misc.pd(new String[]{"Input: "+input, "Arg: "+arg.getCommand()});
		String[] ui = input.split(":");
		for (int i = 0; i < ui.length; i++) {
			Misc.pd("ui["+i+"]: "+ui[i]);
		}
		
		try {

			switch (arg) {
			case CUSTOM_COORDINATE:
				int x = Integer.parseInt(ui[1]);
				int y = Integer.parseInt(ui[2]);
				int z = Integer.parseInt(ui[3]);
				idlePos = new RSTile(x, y, z);
				Misc.ps("Set idlePos: "+x+", "+y+", "+z);
				break;
			case BANK_ALL:
				bankAll = Misc.parseString(ui[1]);
				Misc.ps("Set bankAll: "+bankAll);
				break;
			case WORLD:
				world = Integer.parseInt(ui[1]);
				Misc.ps("Set world: "+world);
				break;
			case TRADE_TIMEOUT:
				tradeKillswitch = Integer.parseInt(ui[1]);
				Misc.ps("Set tradeKillswitch: "+tradeKillswitch);
				break;
			default:
				Misc.pd("Failed to parse: " + input);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
