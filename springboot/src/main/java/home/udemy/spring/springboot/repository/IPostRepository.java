package home.udemy.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.udemy.spring.springboot.pojo.Post;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer>{

}
