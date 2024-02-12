package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.BalanceCommand;
import com.geektrust.backend.commands.CheckInCommand;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.commands.PrintSummaryCommand;
import com.geektrust.backend.services.ICheckInService;
import com.geektrust.backend.services.IMetroCardService;
import com.geektrust.backend.services.IPrintSummaryService;
import com.geektrust.backend.services.impl.CheckInService;
import com.geektrust.backend.services.impl.MetroCardService;
import com.geektrust.backend.services.impl.PrintSummaryService;

public class ApplicationConfig {

    private final IMetroCardService metroCardService = new MetroCardService();
    private final ICheckInService checkInService = new CheckInService(metroCardService);
    private final IPrintSummaryService printSummaryService = new PrintSummaryService(checkInService);

    private final BalanceCommand balanceCommand = new BalanceCommand(metroCardService);
    private final CheckInCommand checkInCommand = new CheckInCommand(checkInService);
    private final PrintSummaryCommand printSummaryCommand = new PrintSummaryCommand(printSummaryService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("BALANCE",balanceCommand);
        commandInvoker.register("CHECK_IN",checkInCommand);
        commandInvoker.register("PRINT_SUMMARY",printSummaryCommand);
        return commandInvoker;
    }
}
