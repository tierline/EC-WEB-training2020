#!/bin/bash

echo '-----initialize-----'

gradle build

echo '-----build_success-----'

# cd build/libs

echo '-----deploy-----'

echo 'ssh接続先のipアドレスを入力してください'

read ip

#変数に入れる
path=`pwd`

echo ${path}

echo '-----start-----'

sftp -i ~/.ssh/ec-site-kp.pem ec2-user@${ip}<<EOF 
put ${path}/build/libs/EC-WEB-training2020-0.0.1-SNAPSHOT.jar
exit
EOF

#ec2内での実行
ssh -i ~/.ssh/ec-site-kp.pem ec2-user@${ip}<<EOF
java -jar /home/ec2-user/EC-WEB-training2020-0.0.1-SNAPSHOT.jar
EOF

