package com.infoGames.gameformation.repositories;

import com.infoGames.gameformation.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
