package com.akkasamples.basic.tell;
import akka.actor.UntypedActor;
/**
 * 
 * @author Rakesh
 *
 */
public class HelloActor extends UntypedActor { // extends UntypedActor 

	@Override
	public void onReceive(Object msg) throws Exception { // recieving the message from the AkkaWithMain.java.
		if (msg instanceof String) { // checking the instance of recieved message.
			System.out.println("Given String is :: " + msg);
		}
		unhandled(msg); // if msg is not String then it will be handled by the default handler.
	}

}
