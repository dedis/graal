import sys
import os
import subprocess
import time
import pandas as pd
import csv

# os.environ['HOMEDIR']='/home/ceyhun/dedis-graal/graal/sdk/mxbuild/linux-amd64/GRAALVM_ESPRESSO_NATIVE_CE_JAVA11/graalvm-espresso-native-ce-java11-22.1.0-dev'
run_avgs = list()

def calc_run_avg(measurements):
    # data = list()
    # for m in measurements:
        # data.append(int(m))
    # df = pd.DataFrame(data, columns=['time'])
    # run_avgs.append(df['time'].mean())
    for m in measurements:
        run_avgs.append(float(m))

def calculate_stats():
    df = pd.DataFrame(run_avgs, columns=['avgs'])
    print("Min:", df['avgs'].min())
    print("Average:", df['avgs'].mean())
    print("95th:", df['avgs'].quantile(q=0.95))
    print("Max:", df['avgs'].max())

def exec_java(jfile, wup, num_run):
    # java_class -> Sandbox
    java_class, ext = os.path.splitext(jfile)

    cmd = [os.environ['ESPRESSO_JAVA'], '-truffle', '--log.level=OFF', java_class]
    cmd.append(wup)
    # print(cmd)

    for i in range(num_run):
        proc = subprocess.Popen(cmd, env=dict(os.environ), stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
        stdout, stderr = proc.communicate()

        dec_out = stdout.decode()
        measurements = dec_out.split("\n")
        measurements.remove("")
        calc_run_avg(measurements)

    calculate_stats()

exec_java(sys.argv[1], sys.argv[2], int(sys.argv[3]))
