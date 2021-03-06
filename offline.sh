#!/bin/bash
if [ $# != 2 ]
then
    echo "maybe you shuold type like this:";echo "./offline.sh divice-dataset algorithm"
    exit 1
fi
data=$1;alg=$2
#remove old files
rm -r data
mkdir data
#copy scripts to target dir
cp -r raw_data data/raw_data
cp scripts/prepare.py data/
cp scripts/dbhelper.py data/
cp scripts/util.py data/
cp alg/${alg}_train.py data/train.py
cp alg/${alg}_predict.py data/predictor.py
#go to target dir
cd data/
printf "alg\t${2}\n" > param.txt
printf "device\t${1}\n" >> param.txt
#process data
./prepare.py
#generate training model
./train.py ${data}
#rm scripts
cd ..
mv data/test.db test/test.db
rm data/prepare.py
rm data/train.py
#rm data/alldata.txt
#rm data/train_set.txt
rm -r data/raw_data
