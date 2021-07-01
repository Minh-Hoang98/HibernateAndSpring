package com.hoang.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: " + fortuneService.getFortune();
	}

	// add an init method
	public void doMyStarupStuff() {
		System.out.println("TrackCoach: inside method doMyStarupStuff");
	}
	
	// add an destroy method
	public void doMyStarupYoYo(){
		System.out.println("TrackCoach: inside method doMyStarupYoYo");
	}
}
