package com.msawchuk.appals.config

import com.msawchuk.appals.models.Product
import com.msawchuk.appals.models.User
import com.msawchuk.appals.repositories.ProductRepository
import com.msawchuk.appals.repositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataInitializer {
    @Bean
    fun initDatabase(
            userRepository: UserRepository,
            productRepository: ProductRepository,
    ): CommandLineRunner {
        return CommandLineRunner {
            // Intiailize empty users repo
            if (userRepository.count() == 0L) {
                userRepository.save(
                        User(
                                firstName = "Tony",
                                lastName = "Stark",
                                balance = 3000000.0,
                        )
                )
                userRepository.save(
                        User(
                                firstName = "Steve",
                                lastName = "Rogers",
                                balance = 450000.0,
                        )
                )
                userRepository.save(
                        User(
                                firstName = "Bruce",
                                lastName = "Banner",
                                balance = 725000.0,
                        )
                )
                userRepository.save(
                        User(
                                firstName = "Peter",
                                lastName = "Parker",
                                balance = 27000.0,
                        )
                )
            }

            // Intiailize empty products repo
            if (productRepository.count() == 0L) {
                productRepository.save(
                        Product(
                                name = "Gundam Kit",
                                description = "Gunpla model building kit",
                                quantity = 5,
                                price = 23.0,
                        ),
                )
                productRepository.save(
                        Product(
                                name = "RTX 5090",
                                description = "Next gen graphics card",
                                quantity = 2,
                                price = 3250.0,
                        ),
                )
                productRepository.save(
                        Product(
                                name = "Tim Henson Signature Ibanez Guitar",
                                description =
                                        "Limited edition signature guitar by the goat himself!",
                                quantity = 1,
                                price = 2300.0,
                        ),
                )
                productRepository.save(
                        Product(
                                name = "John Frusciante Signature Guitar",
                                description = "Limited edition strat guitar by the goat himself!",
                                quantity = 3,
                                price = 2400.0,
                        ),
                )
            }
        }
    }
}
