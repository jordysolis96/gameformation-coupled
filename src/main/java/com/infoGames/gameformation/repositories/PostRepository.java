package com.infoGames.gameformation.repositories;

import com.infoGames.gameformation.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
