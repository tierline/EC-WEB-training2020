#!/bin/bash

echo '-----START-----'

echo 'ssh接続先のipアドレスを入力してください'

read ip

#ec2内での実行
ssh -i ~/.ssh/ec-site-kp.pem ec2-user@${ip}<<EOF
java -jar /home/ec2-user/EC-WEB-training2020-0.0.1-SNAPSHOT.jar
EOF

exit

echo '-----END-----'
