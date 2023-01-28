# Overview
This component supplied some useful abilities to help to use redis more easily.

# How to use
## First and important
1. For the best performance and make it easy to manage data in redis, all the data will be serialized to json string before store. So you need to deserialize them your self.
2. There are tow important packages, `tech.guanli.boot.data.redis.plus.component.absolute` and `tech.guanli.boot.data.redis.plus.component.relative`. The absolute one will operate redis use your key derectly. And the relative one will add a prefix before your key automaticly. You can set the prefix by the configuration `tech.guanli.boot.redis-plus.key-prefix`. **Pay attention, the abstract component in these tow packages are same, carefully to distinguish them when you are using.**

## Simple use
If your value is string, and you don't need to read cold data, you can use `SimpleAbsoluteStringReader` and `SimpleRelativeStringReader` in package `tech.guanli.boot.data.redis.plus.component.implement`. They have been registered as spring bean, just inject them.

## Advanced use
1. When you want to control the behaviors when the key is not found in redis, you just need to create a implemention of the abstract class in `tech.guanli.boot.data.redis.plus.component.absolute` and `tech.guanli.boot.data.redis.plus.component.relative`, choose which to use is depends on your need.
2. In your implemention, you just need to implement `readColdData` method, the generic `ColdData` is type of the cold data to read, and `Parameter` is a object to query cold data. When you use `getAndSetIfAbsent`, if your key is mismatch in redis, readColdData will be call automaticly.
3. Register your implemention to spring
4. Inject your bean and use it.