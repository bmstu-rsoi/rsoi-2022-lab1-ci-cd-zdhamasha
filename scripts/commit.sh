#!/bin/sh

gitCommit() {
 hash="$(git log --format='%H' HEAD -n1)"
}

gitSplitCommit()
{
  gitCommit
  commit=$hash
  Splitedcommit="${commit:0:8}"
  }

gitCommitDate()
{

ts="$(git show -s --format=%ct $hash)"
commitDate="$(date -d @$ts +"%Y%m%d")"
}

genreateCommit()
{
  temp1="${commitDate:2:7}"
  date="$temp1-$Splitedcommit"
  echo $date
}

gitCommit
gitSplitCommit
gitCommitDate
genreateCommit
