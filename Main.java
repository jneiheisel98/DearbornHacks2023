import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;


public class Main {

    private int avgExAvgPressure;
    private int avgExAvgFuelCon;
    private int valveTank1; //values should be from [0, 100] indicating fully closed at 0, fully open at 100
    private int valveTank2; //values should be from [0, 100] indicating fully closed at 0, fully open at 100


    //Calc Average Pressure call API
    public double getAvgPressure(int sTime, int eTime, double sPres, double ePres){

        double time = eTime-sTime;
        double curAvgPres = (sPres + ePres) / 2;
        double curAvgPresCon = curAvgPres / time;

        return curAvgPresCon;
    }

    //Calc Average Fuel Consumption call API
    public double getAvgFuel(int sTime, int eTime, double sFuel, double eFeul){

        double time = eTime-sTime;
        double curAvgFuel = (sFuel + eFeul) / 2;
        double curAvgFuelCon = curAvgFuel / time;
        return curAvgFuelCon;

    }



    //Error Catching

    //Alert of Driver
    public String alertDriver(int x){
        //enumerate the alerts
        //insert error checking
        String[] Alerts = {"Fuel Pressure Low",
                "Fuel Consumption Above Normal Levels - Fuel Leak Possible",
                "Fuel Consumption High - Fuel Leak Probable",
                "Fuel Consumption Extreme - Fuel Leak Present",
                "Fuel Tank Pressure Abnormality - Pull Over Immediately",
                "Fuel Tank Leak - Vehicle Transitioning to Battery Operation"};

        return Alerts[x];
    }
    //Counter Measures

        /*
        Counter measures should include reactions to different situations

        1. Fuel Tank Pressure Drop
            Indicates leak in tank, unsure if there is any reactions we can do to mitigate things here. The main storage
            for hydrogen is leaking - the best thing to do is maybe direct the rest of the hydrogen in the
            tank into a purge valve to disperse the remaining hydrogen outside of the car. From what I'm reading, the
            hydrogen disperses very quickly in the atmosphere due to its low density and thus buoyancy - low concern for
            any fires at that point.

            There are likely two tanks of fuel, so emptying one tank would hopefully only cause a loss of fuel mileage
            in the short term for the driver.

            Reactionary Measure: Direct remaining fuel into purge relief valve via flow paths, likely need to open valve
            for the remaining tank to maintain the same pressure into the fuel cell

        2. Fuel Cell Pressure Drop
            In the event of a fuel cell pressure drop without a corresponding drop in pressure from a fuel tank, there
            is a leak somewhere in the fuel path lines. It's unlikely to be within a pipe and much more likely to be at
            the joints of the system (connections between fuel paths like valves, pressure regulators etc.). Depending
            on the physical configuration of the fuel lines, it's likely that there is no way to safely operate the vehicle
            at this time.

            The only way would be if the tanks have separate fuel lines which could be troubleshooted by
            diagnostics/software to locate the leak. This could be a design consideration, but usually extra piping is
            avoided to save on weight/cost for vehicles. It could be considered in this system as this type of leak
            will otherwise cause the vehicle to need to stop fully and be repaired.

            Reactionary Measure: Direct driver to pull over in an emergency situation(?), close the valves to the fuel
            tanks in a ramp fashion (y=-x). This also could be initiated by the driver (i.e. an alert flashes and awaits
            user confirmation of the alert before ramping down). This way, the driver has a little bit more control over
            the situation and can navigate to a safe stopping location instead of being thrust into a situation where
            they MUST pull over immediately.

        3. Fuel Cell Overpressure
            Does this mean that the pressure control valve for the tank is malfunctioning, allowing too much hydrogen
            into the fuel cell?

            Reactionary Measure: Engineering controls should have a pressure relief valve installed in this case to direct the extra fuel
            outside. It would probably be prudent to alert the driver and update the remaining fuel/mileage from the
            other tank. After the tank is empty, the valve for the other tank would need to be opened to stabilize the
            pressure in the fuel cell

        4. Battery Overcharge
            Unsure what needs to be done here, or if we are assuming we have some sort of overcharge protection built-in

        5. Fuel Cell Overheat?
            If fuel cell is overheating, need to introduce more air to cool the fuel cell. Unsure of likelihood of this

            Reactionary Measure: Open the valve that controls the flow rate of air into the fuel cell until temperature
            stabilizes

        ****Summary****
        We have a few reactionary measures that I think we need code for:
            1. Direct fuel from either tank 1 or tank 2 into purge relief valve
            2. Open valve for tank 1
            3. Open valve for tank 2
            4. Alert drive to unsafe driving conditions (can use enumerated list when we get that up)
            5. Ramp fuel down for both fuel tanks
            6. Adjust rate of ambient air flow into fuel cell (to adjust fuel cell temperature)

         */

    // 1. Direct fuel from either tank 1 / tank 2 into purge relief valve
        //This will take input of which tank needs to be purged



    // Shut Valve

    // Run off battery Call API

    // Reduce Pressure

    // Safe Pressure


    public void limpHomeMode() throws InterruptedException {

    //1. Upon detecting failure mode, alert is sent to user interface
        //call alert with status 6
        alertDriver(6); //"Fuel Tank Leak - Vehicle Transitioning to Battery Operation"

        System.out.println("Press any key to continue...");

    //2. User input confirms the execution of Limp home mode or it activates after 30 seconds
        try {
            boolean exceededTime = false;
            while (System.in.available() == 0 && !exceededTime) {
                Thread.sleep(30000);
                exceededTime = true;
            }
        //3. Program then begins to ramp down fuel input into the fuel cell
            //while either valve is open, slowly decrease the percentage every by 1 every 100ms
            while(valveTank1 > 0 || valveTank2 > 0) {
                if(valveTank1 > 0){ valveTank1 = valveTank1 - 1; }
                if(valveTank2 > 0){ valveTank2 = valveTank2 - 1; }
                Thread.sleep(500); //change this to change how fast it ramps down
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}


