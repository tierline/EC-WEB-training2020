#!/bin/bash

echo 'ssh接続先のipアドレスを入力してください'

read ip

ssh -i ~/.ssh/ec-site-kp.pem ec2-user@${ip}


# path=`pwd`

# echo '-----initialize-----'

# gradle build

# echo '-----build_success-----'

# cd build/libs

# echo '-----springboot-Run-----'

# ./EC-WEB-training2020-0.0.1-SNAPSHOT.jar

# #ec2内での実行↓
# #java -jar /home/ec2-user/EC-WEB-training2020-0.0.1-SNAPSHOT.jar

# echo '-----OK-----'

# cd ../../

# echo '-----finish-----'