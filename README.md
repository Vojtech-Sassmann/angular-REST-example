# Angular REST demo application

Prerequisites: Maven, Curl
 
### Install Node.js
```
sudo apt update
curl -sL https://deb.nodesource.com/setup_11.x | sudo -E bash -
sudo apt-get install -y nodejs
```

### Install Angular CLI
```
npm install -g @angular/cli
```

### Clone the repository
```
(SSH)
git clone git@github.com:Vojtech-Sassmann/angular-REST-example.git / 
(HTTPS)
git clone https://github.com/Vojtech-Sassmann/angular-REST-example.git
```

## Step 1 
```
git checkout step1
```

### Create new angular project
```
ng new gui --routing=true --minimal=true --skipGit=true --style=sass
cd gui
npm install --save bootstrap
```

### Edit the angular.json file
```
{
  ...
  "projects": {
    "gui": {
      ...
      "architect": {
        "build": {
           ...
          "options": {
              ...
            ],
            "styles": [
              "./node_modules/bootstrap/dist/css/bootstrap.css",
              "src/styles.css"
            ],
            ...
          },
        ...
```

### Start GUI app
```
cd gui
ng serve -o
```

## Step 2
```
git checkout step2
```

### Create new component

```
ng generate component InstancesOverview 
```
or 
```
ng g c InstancesOverview
```

## Field with instances
```
instances : PerunInstance[] = [
    {
      id : 1,
      version : "3.4.5",
      owner : "Vojtech Sassmann",
      url : "perun.cesnet.cz"
    },
    {
      id : 2,
      version : "3.2.5",
      owner : "Martin Kuba",
      url : "perun-dev.cesnet.cz"
    }
  ];
```
