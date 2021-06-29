package lambda;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.MetricDatum;
import com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazonaws.services.cloudwatch.model.PutMetricDataResult;
import com.amazonaws.services.cloudwatch.model.StandardUnit;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;


import java.util.Date;


public class Lambda1 implements RequestHandler<ScheduledEvent, String> {

    @Override
    public String handleRequest(ScheduledEvent event, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Current time is "+new Date()+" from lambda1 corn job");

        final AmazonCloudWatch cw =
                AmazonCloudWatchClientBuilder.defaultClient();

        Dimension dimension = new Dimension()
                .withName("CloudWatchSelfLearningDimensionName")
                .withValue("URLS");
        logger.log("FirstStep: Create dimension");

        Double data_point = (double) ((new Date()).getTime() % 2);
        logger.log("data_point is " + data_point);
        MetricDatum datum = new MetricDatum()
                .withMetricName("CloudWatchSelfLearningMetricName")
                .withUnit(StandardUnit.Seconds)
                .withValue(data_point)
                .withDimensions(dimension);
        logger.log("SecondStep: Create MetricDatum");

        PutMetricDataRequest request = new PutMetricDataRequest()
                .withNamespace("SITE/TRAFFIC")
                .withMetricData(datum);
        logger.log("ThirdStep: Create PutMetricDataRequest");

        PutMetricDataResult response = cw.putMetricData(request);
        return "200 OK" + new Date() + "Response is :" + response;
    }

}
