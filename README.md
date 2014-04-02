====BASIC IDEA====
This is a solution for wlan positioning. It is proposed on the basis of machine learning algorithm and therefore composed of two seperate phases: offline and online. This solution is based on client-server mode.

Offline phase would process raw data, split the whole dataset into training set(70%) and testing set(30%), and eventually yeild a training model according to records from training set, using certain algorithm.

Online phase would launch a positioning server after some initialization, the server would wait for request and call predict algorithm to return a result.

Apart from offline and online phase, we supply an extra testing phase for users to examine both efficiency and accuracy of certain algorithm.

====HOW TO USE====
offline phase: 
	./offline.sh <device_dataset> <algorithm>. 
	example: ./offline.sh htc NN

online phase: 
       just "./online"

testing phase: 
	./test.py <device_dataset>. 
	example: ./test.py htc
	./gen_test.py <device_dataset> will randomly generate testing dataset from specified device_dataset

====DEPENDENCY====
scikit-learn is required
currently only available on linux
(will migrate to windows soon)

====MANIFEST====
online.sh
offline.sh
raw_data: measured data categried by device are available here
alg: all algorithms available for training and predicting
scripts: some necessary scripts, including the positioning server
test: scripts for test are available here

====BUG REPORT LIST====
zchgeek@gmail.com
wchgeek@gmail.com

=========================
+ CALL FOR CONTRIBUTORS +
=========================
This project is newly found, any advice and contribution are welcomed.