FROM node:latest AS build
WORKDIR /app
COPY package*.json ./
RUN npm ci

RUN npm install -g @angular/cli
COPY . .
RUN npm run build --configuration=production

### STAGE 2: Run ###
FROM nginx:alpine
COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist/frontend/browser /usr/share/nginx/html
EXPOSE 80
