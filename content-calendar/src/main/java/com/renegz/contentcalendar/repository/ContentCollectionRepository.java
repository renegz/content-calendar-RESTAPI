package com.renegz.contentcalendar.repository;

import com.renegz.contentcalendar.model.Content;
import com.renegz.contentcalendar.model.Status;
import com.renegz.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository //Anotarlo como repositorio genera una instancia de esta clase
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public void delete(Integer id){
        contentList.removeIf(c -> c.id().equals(id));
    }

    public boolean existsById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }



    @PostConstruct
    private void init(){
        Content content = new Content(1,
                "Mi bonito primer post",
                "Descripcion fea",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentList.add(content);
    }
}
