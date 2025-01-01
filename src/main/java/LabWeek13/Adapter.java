package LabWeek13;

interface OldDevice{
    void operateOldFunction();
}

interface NewDevice{
    void operateNewFunction();
}

class OldDeviceImpl implements OldDevice {
    @Override
    public void operateOldFunction() {
        System.out.println("Operating the old device's function.");
    }
}

class NewDeviceImpl implements NewDevice {
    @Override
    public void operateNewFunction() {
        System.out.println("Operating the new device's function.");
    }
}

class DeviceAdapter implements NewDevice{
    private OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice) {
        this.oldDevice = oldDevice;
    }

    public void operateNewFunction(){
        System.out.println("Adapting to new function.");
        oldDevice.operateOldFunction();
    }
}


class Adapter{
    public static void main(String[] args) {

        OldDevice oldDevice = new OldDeviceImpl();

        NewDevice newDevice = new DeviceAdapter(oldDevice);

        System.out.println("Using the device through the new interface:");
        newDevice.operateNewFunction();

        NewDevice newDeviceImpl = new NewDeviceImpl();
        System.out.println("\nUsing the new device directly:");
        newDeviceImpl.operateNewFunction();
    }
}

