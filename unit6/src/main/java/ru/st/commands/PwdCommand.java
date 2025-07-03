package ru.st.commands;

import ru.st.Command;
import ru.st.CommandInfo;

@CommandInfo(name="pwd", Description = "выводит текущий рабочий каталог")
public class PwdCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
