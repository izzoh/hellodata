package io.isengard.mapreduce.mapper;
/**
 * Created by nickrobinson on 1/15/16.
 * nick@isengard.io
 */
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FrequencyMapper
        extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable ONE = new IntWritable(1);

    @Override
    public void map(LongWritable offset, Text lineText, Context context)
            throws IOException, InterruptedException {

        String line = lineText.toString();
        String eventID = line.split(",")[1];
        context.write(new Text(eventID), ONE);
    }
}

