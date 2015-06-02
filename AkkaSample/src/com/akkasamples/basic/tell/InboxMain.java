/**
 * 
 */
package com.akkasamples.basic.tell;

import java.util.concurrent.TimeUnit;

import scala.concurrent.duration.FiniteDuration;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;

/**
 * @author chouhan_r
 *
 */
public class InboxMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("SampleSystem");
		final Inbox inbox = Inbox.create(system);// create inbox so that we can communicate Akka System Actors.
		ActorRef target = system.actorOf(Props.create(HelloActor.class),"HelloActor");
		inbox.watch(target);
		inbox.send(target, "Hello from inbox"); // send message from outside the actor system.
		ActorSelection selection = system.actorSelection("/user/HelloActor");
		
		selection.tell("This is from selection", ActorRef.noSender());
		selection.resolveOne(FiniteDuration.apply(10, TimeUnit.SECONDS));
		
		system.shutdown();
	}

}
