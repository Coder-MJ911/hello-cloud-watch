package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;

import java.util.Date;

public class Lambda2 implements RequestHandler<ScheduledEvent, String> {
    @Override
    public String handleRequest(ScheduledEvent input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Current time is "+new Date()+" from lambda1 corn job");
        double data_point = ( (double) ((new Date()).getTime() % 2) );
        logger.log("data is " + data_point);
        return "";
    }
}
