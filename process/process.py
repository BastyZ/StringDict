import os
import re
import shutil
import sys

regex = '[|°!"@#$.%?\\-+*{};,:<>~¬0123456789/^=_\'`()\[\]]'
alfabeta ='[abcdefghijklmnopqrstuvwxyz ]'
pattern = re.compile(alfabeta)
# IMPORTANTE PYTHON 3.X
if __name__ == '__main__':
    # Lectura
    args = sys.argv[1:]
    if len(args) != 0:
        print('La cantidad de argumentos es 0 usted ingreso ' + str(len(args)))
        sys.exit(1)

    dir_path = os.path.dirname(os.path.realpath(__file__))
    data_path = dir_path + "/data/"
    process_path = dir_path + "/out/"
    if os.path.exists(process_path):
        shutil.rmtree(process_path)
    os.makedirs(process_path)

    for file in os.listdir(data_path):
        filename = os.fsdecode(file)
        print(filename)
        if filename.endswith(".txt"):
            number = 0
            out = open(process_path + filename[:-4] + "processed.txt", "w+", encoding="utf8")
            with open(data_path + filename, "r") as ins:
                for line in ins:
                    sentence = re.sub(regex, '', line)
                    sentence = sentence.lower()
                    sentence = sentence.strip(' ')
                    sentence = sentence.strip('\t')
                    sentence = re.sub(' +', ' ', sentence)
                    number += len(sentence.split())
                    if not pattern.match(sentence) and sentence != "" and sentence != "\n" and sentence != "\r\b":
                        print(sentence)
                        sys.stderr.write("Not ascii Characters")
                        exit(-1)
                    if sentence != "" and sentence != "\n" and sentence != "\r\b":
                        out.write(sentence)
            print("Words " + str(number))
            out.close()
        else:
            continue
