package com.example.courseap;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
@Autowired
TopicRepository topicRepository;
         private List<Topic> topics=new ArrayList<>(Arrays.asList(
           new Topic("Spring", "Spring Framework", "Spring Framework Description"),
           new Topic("Java", "Core Java", "Core Java Description"),
           new Topic("JavaScript", "JavaScript", "JavaScript Description")
    ));
    public List<Topic> getAllTopics() {
        return (List<Topic>) topicRepository.findAll();
    }
    public Topic getTopic(String id){

        return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
    String description=topic.getDescription();
        System.out.println(description);
        String reverse="";
        char[] palindrome=description.toCharArray();
        for(int i=palindrome.length-1;i>=0;i--){
            reverse=reverse +description.charAt(i);}
        System.out.println(reverse);
        if(topic.getDescription().equals(reverse)){
        topicRepository.save(topic);
        System.out.println("it is a palindrome");
        }else {
            System.out.println("not a palindrome");
        }}


        public void updateTopic(String id,Topic topic) {
            int num = Integer.parseInt(id);
            if(num %2==0) {
                topicRepository.save(topic);
                System.out.println("odd");
        }else{
                topicRepository.delete(topic);
                System.out.println("it is not odd");
            }
    }


    public void deleteTopic(String id) {
        int num=Integer.parseInt(id);
        if(num%2==0) {
          //  topics.removeIf(t -> t.getId().equals(id));
            topicRepository.deleteById(id);
            System.out.println("even");
        }}}

