package com.example.ApiService;

import com.example.ApiController.TopicStructure;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Spring Boot creates only 1 instance of Service class to run throughout the course of application
//To access the Service instance in other class(Controller) we have to create an instance manually in that class

@Service
public class ApiService {
    private static List<TopicStructure> topics = new ArrayList<>(
            Arrays.asList(new TopicStructure("java", "JAVA 8", "Programming Lang"),
                    new TopicStructure("python", "Python","Python Programming Lang")));

    public List<TopicStructure> getAllTopics()
    {
        return topics;
    }

    public static TopicStructure getSingleTopic(String id) {
        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();

    }

    public void addTopic(TopicStructure topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, TopicStructure topic) {
        for(int i=0;i<topics.size();i++)
        {
            TopicStructure t = topics.get(i);
            if(t.getId().equals(id))
            {
                topics.set(i, topic);
                return;
            }
        }

    }

    public void deleteTopic(String id, TopicStructure topic) {
        topics.removeIf(t->t.getId().equals(id));
    }
}
