FROM node:18-alpine

WORKDIR /app

ENV VITE_API_URL=http://localhost:8080/api

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 5173

CMD ["npm", "run", "dev"]