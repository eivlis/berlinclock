package com.hotels.silvievyhnankova.berlinclock;


import com.hotels.silvievyhnankova.berlinclock.model.Time;
import com.hotels.silvievyhnankova.berlinclock.presenter.BerlinClockStringPresenterImpl;
import com.hotels.silvievyhnankova.berlinclock.presenter.BerlinClockPresenter;
import com.hotels.silvievyhnankova.berlinclock.service.ConsolePrinter;
import com.hotels.silvievyhnankova.berlinclock.service.Printer;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) throw new IllegalArgumentException("Missing mandatory arguments. (hrs, min, sec)");
        Time time = getTimeFromArgs(args);

        BerlinClockPresenter<String> visualizer = new BerlinClockStringPresenterImpl();
        //based on condition in the test 'Implement the Berlin Clock as a function of the three parameters'
        //without this condition, I would send just one parameter time
        String berlinClock = visualizer.display(time.getHrs(), time.getMin(), time.getSec());

        Printer printer = new ConsolePrinter();
        printer.printLine("---" + time.toString() + "---");
        printer.printLine(berlinClock);
        printer.printLine("--------------");
    }

    private static Time getTimeFromArgs(String[] args) {
        Time time;
        try {
            Integer hrs = Integer.valueOf(args[0]);
            Integer min = Integer.valueOf(args[1]);
            Integer sec = Integer.valueOf(args[2]);
            time = Time.of(hrs, min, sec);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid arguments. Arguments have to be numbers.");
        }
        return time;
    }
}
