/*
 * Copyright 2020 赖柄沣 bingfengdev@aliyun.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package pers.lbf.dockercomposewebdemo.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赖柄沣 bingfengdev@aliyun.com
 * @version 1.0
 * @date 2021/9/2 21:29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sayHello")
public class HelloController {

    private final RedisTemplate<String, Integer> redisTemplate;

    @GetMapping("/{name}")
    public String sayHello(@PathVariable("name") String name) {
        Integer i = redisTemplate.opsForValue().get(name);
        if (i == null) {
            redisTemplate.opsForValue().set(name, 1);
            return "你好！" + name + " 欢迎访问我！";

        }
        i += 1;
        redisTemplate.opsForValue().set(name, i);

        return "你好！" + name + " 这是你第" + i + "次访问我";

    }

}
