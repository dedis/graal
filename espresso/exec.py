import sys
import os
import subprocess
import time
import pandas as pd
import csv

os.environ['LD_DEBUG']="unused"
os.environ['HOMEDIR']='/home/ceyhun/dedis-graal/graal/sdk/mxbuild/linux-amd64/GRAALVM_ESPRESSO_NATIVE_CE_JAVA11/graalvm-espresso-native-ce-java11-22.1.0-dev'

header = ['time']

def write_csv(measurements):
    data = list()
    for m in measurements:
        data.append([int(m)])

    with open("./data.csv", "w") as f:
        writer = csv.writer(f)
        writer.writerow(header)
        writer.writerows(data)
    f.close()

def calculate_stats():
    df = pd.read_csv("./data.csv")

    print("Count:", df['time'].count())
    print("Min:", df['time'].min())
    print("Average:", df['time'].mean())
    print("95th:", df['time'].quantile(q=0.95))
    print("Max:", df['time'].max())

def exec_java(jfile, exp_type, wup):
    # java_class -> Sandbox
    java_class, ext = os.path.splitext(jfile)

    bin = os.environ['HOMEDIR'] + '/bin/java'

    cmd = [bin, '-truffle', java_class]
    cmd.append(exp_type)
    cmd.append(wup)

    print(cmd)

    proc = subprocess.Popen(cmd, env=dict(os.environ), stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    stdout, stderr = proc.communicate()

    dec_out = stdout.decode()
    measurements = dec_out.split("\n")
    measurements.remove("")

    write_csv(measurements)
    calculate_stats()

exec_java(sys.argv[1], sys.argv[2], sys.argv[3])
