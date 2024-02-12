package com.geektrust.backend.commands;

import com.geektrust.backend.services.IPrintSummaryService;

import java.util.List;

public class PrintSummaryCommand implements ICommand{

    private IPrintSummaryService printSummaryService;

    public PrintSummaryCommand(IPrintSummaryService printSummaryService){
        this.printSummaryService=printSummaryService;
    }
    @Override
    public void execute(List<String> tokens) {
        printSummaryService.printSummary();
    }
}
