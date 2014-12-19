package com.akkasamples.basic.tell;
import akka.actor.UntypedActor;

public class HelloActor extends UntypedActor {

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof String) {
			System.out.println("Given String is :: " + msg);
		}
	}

}
