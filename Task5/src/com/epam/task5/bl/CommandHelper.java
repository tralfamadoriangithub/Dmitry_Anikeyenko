package com.epam.task5.bl;

import java.util.HashMap;
import java.util.Map;

import com.epam.task5.bl.impl.NoSuchCommand;
import com.epam.task5.bl.impl.ParseCommand;

public final class CommandHelper {
	private static final CommandHelper instance;
	
	static{
		instance = new CommandHelper();
	}
	
	private Map<CommandName, ICommand> commands = new HashMap<CommandName, ICommand>();
	
	private CommandHelper(){
		commands.put( CommandName.PARSE_COMMAND, new ParseCommand() );
		commands.put( CommandName.NO_SUCH_COMMAND, new NoSuchCommand() );
	}
	
	public static CommandHelper getInstance(){
		return instance;
	}
	
	public ICommand getCommand ( String commandName ){
		
		CommandName name = CommandName.valueOf( commandName.toUpperCase() );
		ICommand command;
		if( name != null){
			command = commands.get( name );
		}else{
			command = commands.get( CommandName.NO_SUCH_COMMAND );
		}
		
		return command;
	}
}
