package ru.st.commands;

import ru.st.*;

@CommandInfo(name = "done", description = "команда обновляет статус на завершенный в задаче")
public class DoneCommand implements Command {
    CommandReceiver receiver;

    public DoneCommand(CommandReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws CommandExecutionException {
        receiver.done(args[0]);
    }
}
