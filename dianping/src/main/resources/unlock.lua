--获取锁中的线程标示 get key
--比较线程标示与锁中标示是否一致
if(redis.call('get',KEYS[1]) == ARGV[1]) then
    return redis.call('del',KEYS[1])
end
return 0;