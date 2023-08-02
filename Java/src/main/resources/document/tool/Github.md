## GitHub常见命令

### 删除.idea文件夹

1. 将.idea加入gitignore清单

   echo .idea >> .gitignore

2. 删除idea缓存

   git rm --cached -r .idea
3. 将.gitignore加入git

   git add .gitignore
4. 提交.gitignore，并将.idea从(git上)源代码中删除

   git commit -m "gitignore commit"

5. push

   git push origin master