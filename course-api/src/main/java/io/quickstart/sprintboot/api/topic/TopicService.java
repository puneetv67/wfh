package io.quickstart.sprintboot.api.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
// this Business Service annotation creates a SINGLETON instance of the class
public class TopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("Spring", "Spring Framework", "Spring framework description"),
					new Topic("Java", "Java course", "Java course description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopicById(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

		/*
		 * for(Topic obj: topics){ if(obj.getId().equals(id)){ return obj; } }
		 * return new Topic("NA", "NA","No topic exists with provided id");
		 */
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {

		for (Topic obj : topics) {
			if (obj.getId().equals(id)) {
				obj.setId(topic.getId());
				obj.setDescription(topic.getDescription());
				obj.setName(topic.getName());
			}
		}

	}
	
	public void deleteTopic(String id){
		topics.removeIf(t->t.getId().equals(id));
	}
}
