package com.example.ApiController;

import com.example.ApiService.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ApiController {

    //Autowired's annotation checks if there is an existing object of apiService(ApiService class), if yes then it will map that instance to the
    //created one below
    @Autowired
    private ApiService apiService; //created to control the services defined in serviceClass
    @RequestMapping("/topics")
    public List<TopicStructure> getAllTopics()
    {
        return apiService.getAllTopics();
    }

    @RequestMapping("topics/{id}") //{var} is used for dynamic inputs in weblink to access different records
    public TopicStructure getSingleTopic(@PathVariable String id)
    {
        return ApiService.getSingleTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics") //Map all the incoming post requests from /topic to below function
    public void addTopic(@RequestBody TopicStructure topic)
    {
        apiService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}") //Map all the incoming post requests from /topic to below function
    public void updateTopic(@RequestBody TopicStructure topic,@PathVariable String id)
    {
        apiService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}") //Map all the incoming post requests from /topic to below function
    public void deleteTopic(@RequestBody TopicStructure topic,@PathVariable String id)
    {
        apiService.deleteTopic(id, topic);
    }

}
