package dev.sijunyang.monitoringdemo

import dev.sijunyang.monitoringdemo.user.User
import dev.sijunyang.monitoringdemo.user.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InitRunner {
    @Bean
    fun initDatabase(userRepository: UserRepository) = CommandLineRunner {
        userRepository.save(User(name = "John Doe", email = "john.doe@example.com"))
        userRepository.save(User(name = "Jane Smith", email = "jane.smith@example.com"))
    }
}
