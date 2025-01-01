package LabWeek13;

interface TrafficLightState {
    void transitionToRed(TrafficLightContext context);
    void transitionToGreen(TrafficLightContext context);
    void transitionToYellow(TrafficLightContext context);
}

class RedLightState implements TrafficLightState {
    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Already in Red state.");
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Transitioning from Red to Green.");
        context.setState(new GreenLightState());
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Transitioning directly from Red to Yellow.");
    }
}

class YellowLightState implements TrafficLightState {
    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Transitioning from Yellow to Red.");
        context.setState(new RedLightState());
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Transitioning directly from Yellow to Green.");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Already in Yellow state.");
    }
}

class GreenLightState implements TrafficLightState {
    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Cannot transition directly from Green to Red.");
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Already in Green state.");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Transitioning from Green to Yellow.");
        context.setState(new YellowLightState());
    }
}

class TrafficLightContext {
    private TrafficLightState currentState;

    public TrafficLightContext() {
        this.currentState = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void transitionToRed() {
        currentState.transitionToRed(this);
    }

    public void transitionToGreen() {
        currentState.transitionToGreen(this);
    }

    public void transitionToYellow() {
        currentState.transitionToYellow(this);
    }
}

class TrafficLightStates{
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();

        System.out.println("Initial State: Red");

        context.transitionToGreen();

        context.transitionToYellow();

        context.transitionToRed();

        context.transitionToYellow();
    }
}
