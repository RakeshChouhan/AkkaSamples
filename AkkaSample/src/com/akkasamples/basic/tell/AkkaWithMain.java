package com.akkasamples.basic.tell;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;



/**
 * Hello World application in AKKA with the main method.
 * @author chouhan_r
 *
 */
public class AkkaWithMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("HelloAKKA"); // Created actor system with name HelloAKKA.
		ActorRef helloRef = system.actorOf(Props.create(HelloActor.class)); // Create Actor instance.
		helloRef.tell("Hello Akka World", helloRef.noSender()); // Send messsage to the Actor.
		system.shutdown();// Finally shut down the Actor system.
	}

}
