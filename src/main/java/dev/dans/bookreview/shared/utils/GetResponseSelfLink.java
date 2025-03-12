package dev.dans.bookreview.shared.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


public class GetResponseSelfLink {
    public static String getSelfLink(){
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .toUriString();
    }

    public static String getSelfLink(Long id){
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUriString();
    }
}
