CREATE IF NOT EXISTS TABLE `podmolot`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(55) NOT NULL,
  `last_name` VARCHAR(55) NULL,
  `midle_name` VARCHAR(55) NULL,
  `password` VARCHAR(100) NULL,
  `phone_number` VARCHAR(100) NULL,
  `mail` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table for users';

CREATE IF NOT EXISTS TABLE `podmolot`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Roles for user';

CREATE IF NOT EXISTS TABLE `podmolot`.`user_role` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `role_fk_idx_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `user_fk_idx`
    FOREIGN KEY (`user_id`)
    REFERENCES `podmolot`.`user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `role_fk_idx`
    FOREIGN KEY (`role_id`)
    REFERENCES `podmolot`.`role` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'User role reference';