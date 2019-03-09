package ch.fhnw.util;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import ch.fhnw.TimeService;
import ch.fhnw.model.Information;

public class BGThread extends Thread {

	private TimeService timeService;
	private static final Logger LOG = LogManager.getLogger(BGThread.class);

	public BGThread(TimeService timeService) {
		this.timeService = timeService;
	}
	
	/**
	 * HauptThread. Prueft jede Sekunde, ob eine konfigurierte Zeit erreicht wurde. 
	 * Anschliessend wird ein Pin des Raspberry angesteuert.
	 */
	public void run() {
		while (true) {
			try {
				sleep(1000);
				List<Information> data = timeService.getTSEntries();
				for (Information infoObj : data) {
					long currentTime = System.currentTimeMillis();
					if (infoObj.getTimestamp() < currentTime + 500 && infoObj.getTimestamp() > currentTime - 500) {
						// do something
						System.out.println("do something..." + infoObj.getTimestamp() + ":"
								+ TSUtil.convertTimeStamp(infoObj.getTimestamp()));

						GpioController gpio = null;
						GpioPinDigitalOutput pin = null;
						System.out.println("setup pi system...");
						gpio = GpioFactory.getInstance();
						pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.HIGH);
						pin.setShutdownOptions(true, PinState.LOW);
						System.out.println("switch on...");
						sleep(5000);
						System.out.println("shutdown pi system...");
						pin.toggle();
						gpio.shutdown();
						LOG.info("GPIO System Shutdown");
						gpio.unprovisionPin(pin);

					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}
}
