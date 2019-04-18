package pattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Staff
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/12 0012 16:40
 * @Version 1.0
 **/
public class Staff {
    private List<Command> commandList=new ArrayList<>();
    public void addCommands(Command command){
        commandList.add(command);
    }

    public void executeCommands(){
        for(Command command:commandList){
            command.execute();
        }
        commandList.clear();
    }
}
