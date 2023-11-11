// Command interface
interface Command {
    void execute();
}

// Concrete Command class for enabling dark mode
class EnableDarkModeCommand implements Command {
    private Light light;

    public EnableDarkModeCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.enableDarkMode();
    }
}

// Concrete Command class for disabling dark mode
class DisableDarkModeCommand implements Command {
    private Light light;

    public DisableDarkModeCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.disableDarkMode();
    }
}

// Receiver class
class Light {
    private boolean isDarkMode = false;

    public void enableDarkMode() {
        isDarkMode = true;
        System.out.println("Dark Mode enabled");
    }

    public void disableDarkMode() {
        isDarkMode = false;
        System.out.println("Dark Mode disabled");
    }

    public boolean isDarkMode() {
        return isDarkMode;
    }
}

// Invoker class
class ModeSwitchInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void performModeSwitch() {
        command.execute();
    }
}

// Client code
public class DarkModeClient {
    public static void main(String[] args) {
        // Create the receiver (Light)
        Light light = new Light();

        // Create concrete command objects
        Command enableDarkModeCommand = new EnableDarkModeCommand(light);
        Command disableDarkModeCommand = new DisableDarkModeCommand(light);

        // Create the invoker (ModeSwitchInvoker)
        ModeSwitchInvoker modeSwitchInvoker = new ModeSwitchInvoker();

        // Enable Dark Mode
        modeSwitchInvoker.setCommand(enableDarkModeCommand);
        modeSwitchInvoker.performModeSwitch();

        // Check the state of the light after enabling dark mode
        System.out.println("Dark Mode enabled: " + light.isDarkMode());

        // Disable Dark Mode
        modeSwitchInvoker.setCommand(disableDarkModeCommand);
        modeSwitchInvoker.performModeSwitch();

        // Check the state of the light after disabling dark mode
        System.out.println("Dark Mode enabled: " + light.isDarkMode());
    }
}
